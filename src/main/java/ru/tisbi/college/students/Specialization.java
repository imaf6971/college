package ru.tisbi.college.students;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ru.tisbi.college.model.TitledEntity;

@Entity
@Table(name = "specializations")
public class Specialization extends TitledEntity {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "specialization_id", nullable = false)
    private List<Group> groups = new ArrayList<>();

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    public List<Group> getGroups() {
        return unmodifiableList(groups);
    }

    public void addGroup(Group group) {
        if (group.isNew()) {
            groups.add(group);
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
