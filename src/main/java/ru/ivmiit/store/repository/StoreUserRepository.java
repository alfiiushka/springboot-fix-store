package ru.ivmiit.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.store.model.StoreUser;

import java.util.Optional;

public interface StoreUserRepository extends JpaRepository<StoreUser, Long> {
    Optional<StoreUser> findOneByLogin(String string);
}
