package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import net.javaguides.sms.entity.Message;
import net.javaguides.sms.service.DoctorService;
import net.javaguides.sms.service.MessageService;

@Controller
public class MessageController {

    private MessageService messageService;
    private DoctorService doctorService;

    public MessageController(MessageService messageService, DoctorService doctorService) {
        super();
        this.messageService = messageService;
        this.doctorService = doctorService;
    }

    @GetMapping("/chat/{doctorId}")
    public String chatWithDoctor(@PathVariable Long doctorId, Model model) {
        model.addAttribute("messages", messageService.getMessagesByDoctorId(doctorId));
        model.addAttribute("doctorId", doctorId);
        return "chat";
    }

    @PostMapping("/chat/{doctorId}")
    public String sendMessage(@PathVariable Long doctorId, @ModelAttribute("message") Message message) {
        message.setDoctor(doctorService.getDoctorById(doctorId));
        messageService.saveMessage(message);
        return "redirect:/chat/" + doctorId;
    }
}
