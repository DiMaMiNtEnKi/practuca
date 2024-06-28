package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.javaguides.sms.entity.Doctor;
import net.javaguides.sms.service.DoctorService;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        super();
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }

    @GetMapping("/doctors/new")
    public String createDoctorForm(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "create_doctor";
    }

    @PostMapping("/doctors")
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String editDoctorForm(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", doctorService.getDoctorById(id));
        return "edit_doctor";
    }

    @PostMapping("/doctors/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute("doctor") Doctor doctor, Model model) {
        Doctor existingDoctor = doctorService.getDoctorById(id);
        existingDoctor.setId(id);
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setProfession(doctor.getProfession());

        doctorService.updateDoctor(existingDoctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/search")
    public String searchDoctors(@RequestParam("query") String query, Model model) {
        model.addAttribute("doctors", doctorService.searchDoctors(query));
        return "doctors";
    }

    // Add the following methods to handle /edit_doctors and /chat routes
    @GetMapping("/edit_doctors")
    public String editDoctors(Model model) {
        // Add necessary attributes to the model, if any
        return "edit_doctor"; // Ensure edit_doctor.html is correctly named
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        // Add necessary attributes to the model, if any
        return "chat"; // Ensure chat.html is correctly named
    }

    @GetMapping("/create_doctors")
    public String createDoctors(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);
        return "create_doctor"; // Ensure create_doctor.html is correctly named
    }
}
