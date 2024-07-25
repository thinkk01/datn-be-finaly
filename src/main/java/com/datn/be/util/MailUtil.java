package com.datn.be.util;

import com.datn.be.entity.Order;
import com.datn.be.entity.Voucher;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

public class MailUtil {
    private static final String EMAIL = "nguyenducthinhdut2@gmail.com";
    private static final String PASSWORD = "vagnxswpoqzsbdgv";
    private static final String HOST = "smtp.gmail.com";
    private static final String PORT = "587";
    private static Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });
    }
    public static void sendEmail(Order order) throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

Session session = getSession();
        // Tạo tin nhắn email
        Message msg = new MimeMessage(session);

        // Đặt địa chỉ người gửi
        msg.setFrom(new InternetAddress(EMAIL, "Shop Shoes Thinkk"));

        // Đặt địa chỉ người nhận
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getEmail()));

        // Tạo nội dung email
        StringBuilder sb = new StringBuilder()
//                .append("Đơn hàng ").append(order.getId()).append("<br/>")
//                .append("Tổng tiền: ").append(order.getTotal()).append("<br/>")
//                .append("Ngày tạo: ").append(order.getCreateDate()).append("<br/>")
//                .append("Người nhận: ").append(order.getFullname()).append("<br/>")
//                .append("SDT: ").append(order.getPhone()).append("<br/>")
//                .append("Địa chỉ: ").append(order.getAddress()).append("<br/>")
//                .append("Theo dõi trạng thái đơn hàng tại đây: ")
//                .append("http://localhost:3000/order/detail/")
//                .append(Base64.getUrlEncoder().encodeToString(String.valueOf(order.getId()).getBytes()));
                .append("<div style='font-family: Arial, sans-serif; color: #333;'>")
                .append("<h2>Thông báo đơn hàng</h2>")
                .append("<p>Đơn hàng: <strong>").append(order.getId()).append("</strong></p>")
                .append("<p>Tổng tiền: <strong>").append(order.getTotal()).append("</strong></p>")
                .append("<p>Ngày tạo: <strong>").append(order.getCreateDate()).append("</strong></p>")
                .append("<p>Người nhận: <strong>").append(order.getFullname()).append("</strong></p>")
                .append("<p>SDT: <strong>").append(order.getPhone()).append("</strong></p>")
                .append("<p>Địa chỉ: <strong>").append(order.getAddress()).append("</strong></p>")
                .append("<p>Theo dõi trạng thái đơn hàng tại đây: ")
                .append("<a href='http://localhost:3000/order/detail/")
                .append(Base64.getUrlEncoder().encodeToString(String.valueOf(order.getId()).getBytes()))
                .append("' style='color: #1a73e8;'>Chi tiết đơn hàng</a></p>")
                .append("</div>");

        msg.setSubject("Shop Shoes Thinkk Thông Báo");
        msg.setContent(sb.toString(), "text/html; charset=utf-8");
        msg.setSentDate(new Date());

        // Gửi email
        Transport.send(msg);
    }

    public static void sendEmail(Voucher voucher, Order order) throws MessagingException, UnsupportedEncodingException {
        Session session = getSession();
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(EMAIL, "Shop Thinkk Shoes thông báo"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getEmail()));

        String emailContent = String.format(
                "<div style='font-family: Arial, sans-serif; color: #333;'>"
                        + "<h2>Thông báo voucher</h2>"
                        + "<p>Bạn nhận được voucher giảm giá cho lần sử dụng tiếp theo:</p>"
                        + "<p>Mã voucher: <strong>%s</strong></p>"
                        + "<p>Số lần sử dụng: <strong>%s</strong></p>"
                        + "<p>Hạn sử dụng: <strong>%s</strong></p>"
                        + "<p>Giảm giá: <strong>%s%%</strong></p>"
                        + "</div>",
                voucher.getCode(),
                voucher.getCount(),
                voucher.getExpireDate(),
                voucher.getDiscount()
        );

        msg.setSubject("Shop Shoes Thinkk thông báo");
        msg.setContent(emailContent, "text/html; charset=utf-8");
        msg.setSentDate(new Date());
        Transport.send(msg);
//
    }

    public static void sendmailForgotPassword(String recipient, String password) throws MessagingException, UnsupportedEncodingException {
        Session session = getSession();
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(EMAIL, "Shop Shoes Thinkk"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

        String emailContent = String.format("<div style='font-family: Arial, sans-serif; color: #333;'>"
                + "<h2>Khôi phục mật khẩu</h2>"
                + "<p>Mật khẩu mới của bạn là: <strong>%s</strong></p>"
                + "</div>", password);

        msg.setSubject("Shop Thinkk Shoes thông báo");
        msg.setContent(emailContent, "text/html; charset=utf-8");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
