package ru.tisbi.college.groups;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groups")
public class GroupsController {

    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public String getGroupList(Model model) {
        model.addAttribute("specializations", groupService.groupsBySpecialization());
        return "groups";
    }

}
