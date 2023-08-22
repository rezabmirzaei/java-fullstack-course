package no.accelerate.postgrads.services.subject;

import org.springframework.stereotype.Service;

import no.accelerate.postgrads.models.Subject;
import no.accelerate.postgrads.repositories.SubjectRepository;

import java.util.Collection;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject findById(Integer id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public Collection<Subject> findAll() {
        return null;
    }

    @Override
    public Subject add(Subject entity) {
        return null;
    }

    @Override
    public Subject update(Subject entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

}
