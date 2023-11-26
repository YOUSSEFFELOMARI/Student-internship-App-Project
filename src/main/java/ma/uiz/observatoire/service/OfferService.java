package ma.uiz.observatoire.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.uiz.observatoire.dto.OfferDTO;
import ma.uiz.observatoire.mapper.OfferMapper;
import ma.uiz.observatoire.model.Offer;
import ma.uiz.observatoire.model.Student;
import ma.uiz.observatoire.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public Page<OfferDTO> showAllOffer(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return offerRepository.findAll(pageable).map(offerMapper::mapToDto);
    }

    public List<OfferDTO> findAll() {
        List<Offer> offers=offerRepository.findAll();
        return offers.stream().map(offerMapper::mapToDto).collect(Collectors.toList());
    }


    public OfferDTO create(OfferDTO offerDTO) {
        Offer offer=offerMapper.mapToModel(offerDTO);
        if (offerRepository.existsById(offer.getOfferId()))
            throw new EntityExistsException("Offer already stored in database - ID : "+offer.getOfferId()) {};
        createOffer(offer);
        return offerDTO;
    }

    public Offer createOffer(Offer offer) {
        if (offerRepository.existsById(offer.getOfferId()))
            throw new EntityExistsException("Offer already stored in database - ID : "+offer.getOfferId()) {};
        return offerRepository.save(offer);
    }

    public void delete(int id) {
        if (!offerRepository.existsById(id))
            throw new EntityNotFoundException("Offer not found - ID : "+id) {};
        offerRepository.deleteById(id);
    }

    public void update(OfferDTO offerDTO) {
        Offer offer=offerMapper.mapToModel(offerDTO);
        if (!offerRepository.existsById(offer.getOfferId()))
            throw new EntityNotFoundException("Offer not found - ID : "+offer.getOfferId()) {};
        offerRepository.save(offer);
    }

    public void updateOffer(Offer offer) {
        if (!offerRepository.existsById(offer.getOfferId()))
            throw new EntityNotFoundException("Offer not found - ID : "+offer.getOfferId()) {};
        offerRepository.save(offer);
    }

    public OfferDTO find(int id) {
        Offer offer= offerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Offer not found - ID : "+id) {});
        return offerMapper.mapToDto(offer);
    }


    public long count() {
        return offerRepository.count();
    }

    public Offer findOffer(int id) {
        return offerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Offer not found - ID : "+id) {});
    }

    public List<OfferDTO> findByCompanyId(int companyId) {
        return offerRepository.findAllByCompanyCompanyId(companyId);
    }
}
