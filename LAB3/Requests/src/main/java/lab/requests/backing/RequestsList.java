package lab.requests.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lab.requests.data.RequestRepository;
import lab.requests.entities.Request;

import java.util.List;

@RequestScoped
@Named
public class RequestsList {
    @Inject
    private RequestRepository requestRepository;
    public List<Request> getAllRequests() {
        // ma posredniczyc w dostepie do metody komponentu repozytorium i udostepniac liste wszystkich obiektow encji
        return requestRepository.findAll();
    }
}
