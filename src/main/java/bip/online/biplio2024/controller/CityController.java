package bip.online.biplio2024.controller;
import bip.online.biplio2024.entity.CityEntity;
import bip.online.biplio2024.response.BaseResponse;
import bip.online.biplio2024.response.DataResponse;
import bip.online.biplio2024.response.ListResponse;
import bip.online.biplio2024.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/city")
@AllArgsConstructor
public class CityController {
    private final CityService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<CityEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<CityEntity>(true, "Список городов: ", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<CityEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Найден следующий город: ", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<CityEntity>> save(@RequestBody CityEntity city) {
        return ResponseEntity.ok(
                new DataResponse<CityEntity>(true, "Город сохранен: ", service.save(city)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody CityEntity city) {
        service.update(city);
        return ResponseEntity.ok(
                new BaseResponse(true, "Город сохранен: "));
    }

}
