package ru.ivmiit.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.store.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByCode(String code);
}
