package com.example.bank.entity;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto)
    {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getAccountNumber(),
                accountDto.getMobile()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getAccountNumber(),
                account.getMobile()
        );

        return accountDto;
    }


    public static FormData mapToForm(FormDataDto accountDto)
    {
        FormData formData = new FormData(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getMobile(),
                accountDto.getEmail(),
                accountDto.getParagraph()
        );

        return formData;
    }

    public static FormDataDto mapToFormDTO(FormData formData)
    {
        FormDataDto formDatadto = new FormDataDto(
                formData.getId(),
                formData.getName(),
                formData.getMobile(),
                formData.getEmail(),
                formData.getParagraph()
        );

        return formDatadto;
    }
}

