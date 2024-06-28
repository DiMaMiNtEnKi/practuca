package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.sms.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
