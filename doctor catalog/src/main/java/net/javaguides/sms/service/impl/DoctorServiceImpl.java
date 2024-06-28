package net.javaguides.sms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Doctor;
import net.javaguides.sms.repository.DoctorRepository;
import net.javaguides.sms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> searchDoctors(String query) {
        return doctorRepository.findAll().stream()
                .filter(doctor -> doctor.getFirstName().toLowerCase().contains(query.toLowerCase()) ||
                        doctor.getLastName().toLowerCase().contains(query.toLowerCase()) ||
                        doctor.getProfession().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
