package mythosforge.fable_minds.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mythosforge.fable_minds.exceptions.BusinessException;
import mythosforge.fable_minds.models.Campaign;
import mythosforge.fable_minds.repository.CampaignRepository;
import mythosforge.fable_minds.service.interfaces.ICampaignService;

@Service
public class CampaignService implements ICampaignService {

    private final CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Campaign create(Campaign campaign) {
        if (campaign == null) {
            throw new BusinessException("Campanha não pode ser nula.");
        }
        return campaignRepository.save(campaign);
    }

    @Override
    public Campaign update(Long id, Campaign campaign) {
        Campaign existing = campaignRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Campanha não encontrada: " + id));

        existing.setTitle(campaign.getTitle());
        existing.setDescription(campaign.getDescription());
        existing.setSystem(campaign.getSystem());
        existing.setUser(campaign.getUser());

        return campaignRepository.save(existing);
    }

    @Override
    public Campaign findById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Campanha não encontrada: " + id));
    }

    @Override
    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    @Override
    public List<Campaign> findByUserId(Long userId) {
        return campaignRepository.findByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        if (!campaignRepository.existsById(id)) {
            throw new BusinessException("Campanha não encontrada: " + id);
        }
        campaignRepository.deleteById(id);
    }
}
