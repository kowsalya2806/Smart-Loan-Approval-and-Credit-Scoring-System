package com.example.LoanApproval.controller;

import com.example.LoanApproval.entity.Loan;
import com.example.LoanApproval.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Show loan application form
    @GetMapping("/apply")
    public String showLoanForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan-apply";
    }

    // Handle loan application submission
    @PostMapping("/apply")
    public String applyLoan(@RequestParam Long userId, @ModelAttribute Loan loan) {
        loanService.applyLoan(userId, loan);
        return "redirect:/loans/status?userId=" + userId;
    }

    // Show loan status for a specific user
    @GetMapping("/status")
    public String viewLoanStatus(@RequestParam Long userId, Model model) {
        List<Loan> loans = loanService.getLoansByUser(userId);
        model.addAttribute("loans", loans);
        return "loan-status";
    }

    // Admin view: list all loans
    @GetMapping("/admin/all")
    public String viewAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        return "admin-loans";
    }
}