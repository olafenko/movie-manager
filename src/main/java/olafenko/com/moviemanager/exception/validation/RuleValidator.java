package olafenko.com.moviemanager.exception.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RuleValidator implements ValidationRule{

    List<ValidationRule> listOfRules;

    @Override
    public boolean validate(String s) {
        return listOfRules.stream().allMatch(validationRule -> validationRule.validate(s));
    }
}
