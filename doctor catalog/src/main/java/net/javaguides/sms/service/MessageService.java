package net.javaguides.sms.service;

import java.util.List;
import net.javaguides.sms.entity.Message;

public interface MessageService {
    List<Message> getAllMessages();
    void saveMessage(Message message);
    List<Message> getMessagesByDoctorId(Long doctorId);
}
