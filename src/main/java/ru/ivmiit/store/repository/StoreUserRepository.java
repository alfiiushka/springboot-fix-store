package ru.ivmiit.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.store.model.StoreUser;

public interface StoreUserRepository extends JpaRepository<StoreUser,Long> {

}
