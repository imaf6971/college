
package ru.tisbi.college.groups;

import java.time.Year;
import java.util.List;
import java.util.Map;

import ru.tisbi.college.specializations.Specialization;

/**
 * GroupService
 */
public interface GroupService {
    List<Group> findAllGroups();

    Group newGroup(Specialization specialization, Year admissionYear, boolean isAfterSeniorSchool,
            short number);

    Group newGroup(GroupDto groupDto);

    Map<Specialization, List<Group>> groupsBySpecialization();
}
