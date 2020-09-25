
package mall.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

// 백엔드에서 msa간 인터페이스 / 어노테이션 ..
@FeignClient(name="delivery", url="${api.delivery.url}")
        //"//http://localhos:8082")

public interface CancellationService {

    //base url + path
    @RequestMapping(method= RequestMethod.POST, path="/cancellations")
    public void cancel(@RequestBody Cancellation cancellation);

}