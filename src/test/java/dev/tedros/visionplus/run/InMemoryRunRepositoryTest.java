package dev.tedros.visionplus.run;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryRunRepositoryTest {

    InMemoryRunRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryRunRepository();

        repository.create(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR, null));

        repository.create(new Run(2,
                "Wednesday Evening Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                6,
                Location.INDOOR, null));

    }

    // @Test
    // void testCount() {

    // }

    @Test
    void testCreate() {
        repository.create(new Run(1, "Monday Morning Run", LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3, Location.INDOOR, null));
        List<Run> runs = repository.findAll();
        assertEquals(3, runs.size());
    }

    @Test
    void testDelete() {
        repository.delete(1);
        List<Run> runs = repository.findAll();
        assertEquals(1, runs.size());
    }

    @Test
    void testFindAll() {
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size(), "Should have returned 2 runs");
    }

    @Test
    void testFindById() {
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(3, run.miles(), "Expect miles 3");
    }

    @Test
    void testFindByInvalidId() {
        RunNotFoundException notFoundException = assertThrows(RunNotFoundException.class,
                () -> repository.findById(3).get());
        assertEquals("Run Not Found", notFoundException.getMessage());
    }

    // @Test
    // void testFindByLocation() {

    // }

    // @Test
    // void testSaveAll() {

    // }

    @Test
    void testUpdate() {
        repository.update(new Run(1, "Monday Morning Run", LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.OUTDOOR, null), 1);
        var run = repository.findById(1).get();
        assertEquals("Monday Morning Run", run.title());
        assertEquals(5, run.miles());
        assertEquals(Location.OUTDOOR, run.location());
    }

}
