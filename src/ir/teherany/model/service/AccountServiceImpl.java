package ir.teherany.model.service;

import ir.teherany.entity.Account;
import ir.teherany.model.repository.AccountDA;

public class AccountServiceImpl implements AccountService {
    private static final AccountServiceImpl accountService = new AccountServiceImpl();

    private AccountServiceImpl() {
    }

    public static AccountServiceImpl getInstance() {
        return accountService;
    }

    @Override
    public void save(Account account) throws Exception {
        try (AccountDA accountDA = new AccountDA()) {
            accountDA.insert(account);
        }
    }
}
