package org.j2os.project.entity;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.10   Hadian
 */
public class Person {
    private Integer id;
    private String name;
    private String family;

    public Person() {
    }

    public Person(Integer id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
