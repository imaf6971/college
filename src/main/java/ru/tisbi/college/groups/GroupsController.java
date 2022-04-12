package ru.tisbi.college.groups;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.tisbi.college.specializations.SpecializationService;

@Controller
public class GroupsController {

    private final GroupService groupService;

    private final SpecializationService specializationService;

    public GroupsController(GroupService groupService, SpecializationService specializationService) {
        this.groupService = groupService;
        this.specializationService = specializationService;
    }

    @GetMapping("/groups")
    public String getGroupList(Model model) {
        model.addAttribute("specializations", groupService.groupsBySpecialization());
        return "groups";
    }

    @GetMapping("/groups/add")
    public String getAddGroupsPage(Model model) {
        var specializations = specializationService.findAllSpecializations();
        model.addAttribute("specializations", specializations);
        model.addAttribute("group", new GroupDto());
        return "group-add";
    }

    @PostMapping("/groups/add")
    public String newGroup(@ModelAttribute @Valid GroupDto group, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "group-add";
        }
        groupService.newGroup(group);
        return "redirect:/groups";
    }
}
