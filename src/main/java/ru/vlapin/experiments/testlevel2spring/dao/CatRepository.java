package ru.vlapin.experiments.testlevel2spring.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.testlevel2spring.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
