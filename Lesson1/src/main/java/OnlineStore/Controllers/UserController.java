package OnlineStore.Controllers;

import OnlineStore.Entities.User;
import OnlineStore.Repositories.RoleRepository;
import OnlineStore.Services.UserRepr;
import OnlineStore.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public String users(@RequestParam(value = "page") Optional<Integer> page,
                          @RequestParam(value = "size") Optional<Integer> size,
                          Model model) {
        Page<User> pageUser = userService.findAll(
                PageRequest.of(page.orElse(1) - 1, size.orElse(7)));

        model.addAttribute("activePage", "users");
        model.addAttribute("userList", userService.ConvertPageUsersToListUsersRepr(pageUser));
        model.addAttribute("usersPage", pageUser);
        return "users";
    }

    @GetMapping("/form")
    public String formUser(@RequestParam(value = "id") Optional<Long> userID,Model model) {
        if (userID.isPresent()) {
            Optional<UserRepr> findUser = userService.findById(userID.get());
            model.addAttribute("user", findUser.get());
            model.addAttribute("roles", findUser.get().getRoles());

        } else {
            model.addAttribute("user", new UserRepr());
            model.addAttribute("roles", roleRepository.findAll());
        }
        return "user_form";
    }

    @PostMapping("/form")
    public String newUser(@Valid UserRepr user, BindingResult result) {
        if (result.hasErrors()) {
            return "user_form";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            result.rejectValue("password", "", "Password not matching");
            return "user_form";
        }

        userService.save(user);
        return "redirect:/users";
    }

}
