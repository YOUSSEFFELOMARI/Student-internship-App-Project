package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.model.OfferType;
import ma.uiz.observatoire.repository.OfferTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferTypeService {

    private final OfferTypeRepository offerTypeRepository;

    public Page<OfferType> showAllOfferType(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return offerTypeRepository.findAll(pageable);
    }

    public List<OfferType> findAll() {
        return offerTypeRepository.findAll();
    }

    public long count() {
        return offerTypeRepository.count();
    }

    public OfferType create(OfferType offerType) {
        if (offerTypeRepository.existsById(offerType.getOfferTypeId()))
            throw new EntityExistsException("OfferType already stored in database - ID : " +
                    offerType.getOfferTypeId()) {};
        return offerTypeRepository.save(offerType);
    }

    public OfferType update(OfferType offerType) {
        if (!offerTypeRepository.existsById(offerType.getOfferTypeId()))
            throw new EntityNotFoundException("OfferType not found - ID : " +
                    offerType.getOfferTypeId()) {};
        return offerTypeRepository.save(offerType);
    }

    public void delete(int id) {
        if (!offerTypeRepository.existsById(id)) throw new EntityNotFoundException("OfferType not found - ID : " + id) {
        };
        offerTypeRepository.deleteById(id);
    }

    public OfferType find(int id) {
        return offerTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("OfferType not found - ID : " + id) {
        });
    }
}
