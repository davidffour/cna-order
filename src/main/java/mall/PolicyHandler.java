package mall;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    @Autowired
    OrderRepository orderRepository;

//shipped 에 있는 상태값을 업데이트 주문과 배송 연동
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_UpdateStatus(@Payload Shipped shipped) {
        //배송의 shipped이벤트가 카프카로 갔을때 오더레파지토리로부터 shipped 이벤트 찾아서 null이 아니면 get해서 order에 넣음
        if (shipped.isMe()) {
            //System.out.println("##### listener UpdateStatus : " + shipped.toJson());
            //optional =null 처리 클래스

            Optional<Order> productOptional = orderRepository.findById(shipped.getOrderId());
            Order order = productOptional.get();
            order.setStatus(shipped.getStatus());

            orderRepository.save(order);
        }
    }}