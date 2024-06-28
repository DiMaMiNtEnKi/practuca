package net.javaguides.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Message;
import net.javaguides.sms.repository.MessageRepository;
import net.javaguides.sms.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        super();
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByDoctorId(Long doctorId) {
        return messageRepository.findAll().stream()
                .filter(message -> message.getDoctor().getId().equals(doctorId))
                .collect(Collectors.toList());
    }
}
