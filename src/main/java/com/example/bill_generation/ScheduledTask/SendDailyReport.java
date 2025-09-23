package com.example.bill_generation.ScheduledTask;

import com.example.bill_generation.Model.Product;
import com.example.bill_generation.Repository.ProductRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@Service
public class SendDailyReport {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ProductRepository productRepository;

    @Scheduled(cron = "0 0 12 * * *")
    public String sendDailyReportOnStartup1() {
        List<Product> products = productRepository.findAll();

        File csvFile = new File("customers.csv");

        try (PrintWriter writer = new PrintWriter(csvFile)) {
            writer.println("ID,prodName,Price,Stock,ThreshHold");

            for (Product c : products) {
                writer.println(c.getId() + "," +
                        c.getProductName() + "," +
                        c.getPrice() + "," +
                        c.getStock() + "," +
                        c.getThreshHold());
            }
            writer.flush();
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("urvishnavadiya2004@gmail.com");
            helper.setTo("urvishnavadiya2004@gmail.com");
            helper.setSubject("🧾 Daily Customer Report");
            helper.setText("Today's customer purchase report is attached.");

            FileSystemResource file = new FileSystemResource(csvFile);
            helper.addAttachment("CustomerReport.csv", file);

            mailSender.send(message);
            System.out.println("Mail sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            csvFile.delete();
        }
        return "something went wrong";
    }
}
