package kh.deli.domain.admin.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import kh.deli.domain.admin.dto.AdminAccountDTO;
import kh.deli.domain.admin.service.AdminAccountService;
import kh.deli.domain.main.service.MainAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/account/list")
public class AccountListController {

    private final AdminAccountService adminAccountService;
    private final MainAccountService mainAccountService;

    @RequestMapping("")
    public String toAdminAccount(Model model) {
        List<AdminAccountDTO> account_list = adminAccountService.selectAccountList();
        model.addAttribute("account_list", account_list);
        return "admin/adminAccountList";
    }

    @RequestMapping("/deleteAccount")
    public String acoounDelete(int acc_seq) throws Exception {
        adminAccountService.deleteAccount(acc_seq);
        //mainAccountService.withdrawal(); 삭제
        return "redirect:";
    }
}
