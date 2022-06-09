package ir.teherany.model.service;

import ir.teherany.entity.Account;

public interface AccountService {
    void save(Account account) throws Exception;
    void findOne (int id) throws Exception;
}
