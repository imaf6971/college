package ru.tisbi.college.groups;

import static java.util.stream.Collectors.groupingBy;

import java.time.Year;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.tisbi.college.specializations.Specialization;
import ru.tisbi.college.specializations.SpecializationRepository;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository, SpecializationRepository specializationRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group newGroup(Specialization specialization, Year admissionYear, boolean isAfterSeniorSchool,
            short number) {
        var group = new Group();
        group.setSpecialization(specialization);
        group.setAdmissionYear(admissionYear);
        group.setAfterSeniorSchool(isAfterSeniorSchool);
        group.setNumber(number);
        return groupRepository.save(group);
    }

    @Override
    public Map<Specialization, List<Group>> groupsBySpecialization() {
        return findAllGroups().stream()
                .collect(groupingBy(Group::getSpecialization,
                        () -> new LinkedHashMap<>(), Collectors.toList()));
    }
}
