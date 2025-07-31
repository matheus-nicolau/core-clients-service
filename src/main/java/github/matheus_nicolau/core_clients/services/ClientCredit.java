package github.matheus_nicolau.core_clients.services;

import github.matheus_nicolau.core_clients.dto.CreditDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name ="finances-gateway", url ="${BASE_URL_GATEWAY}")
public interface ClientCredit {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/credit/list/{limit}", produces = "application/json")
    public ResponseEntity<List<CreditDTO>> listByLimit(@PathVariable String limit);
}
