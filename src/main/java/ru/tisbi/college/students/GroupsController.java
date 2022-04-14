package ru.tisbi.college.students;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupsController {

    private final SpecializationRepository specializationRepository;

    public GroupsController(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @GetMapping("/groups")
    public String getGroups(Model model) {
        addSpecializationsToModel(model);
        return "groups";
    }

    private void addSpecializationsToModel(Model model) {
        model.addAttribute("specializations", groupsBySpecialization());
    }

    private Map<Specialization, List<Group>> groupsBySpecialization() {
        return specializationRepository.findAll()
                .stream()
                .collect(toMap(
                        specialization -> specialization,
                        specialization -> specialization.getGroups()));
    }

    // @GetMapping("/groups/add")
    // public String getAddGroupsPage(Model model) {
    //     var specializations = specializationService.findAllSpecializations();
    //     model.addAttribute("specializations", specializations);
    //     model.addAttribute("group", new GroupDto());
    //     return "group-add";
    // }

    // @PostMapping("/groups/add")
    // public String newGroup(@ModelAttribute @Valid GroupDto group, BindingResult bindingResult) {
    //     if (bindingResult.hasErrors()) {
    //         return "group-add";
    //     }
    //     groupService.newGroup(group);
    //     return "redirect:/groups";
    // }
}
