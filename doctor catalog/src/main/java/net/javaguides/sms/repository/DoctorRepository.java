package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.sms.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
