package dev.melik.bootcamp.week4.q2.controller.rate;

import dev.melik.bootcamp.week4.q2.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @PostMapping("/rates")
    @ResponseStatus(HttpStatus.CREATED)
    public void rate(@RequestBody @Valid RateRequest rateRequest) {
        rateService.postRate(RateRequest.toRate(rateRequest));
    }

    @GetMapping("/rates")
    public List<RateResponse> getRatesByMovieId(@RequestParam Long movieId) {
        return RateResponse.fromRate(rateService.getRatesByMovieId(movieId));
    }
}
