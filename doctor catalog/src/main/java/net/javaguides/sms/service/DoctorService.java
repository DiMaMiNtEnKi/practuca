package net.javaguides.sms.service;

import java.util.List;
import net.javaguides.sms.entity.Doctor;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    Doctor getDoctorById(Long id);
    void updateDoctor(Doctor doctor);
    void deleteDoctorById(Long id);
    List<Doctor> searchDoctors(String query);
}
