//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;

contract Bank {

    address public accHolder;
    uint256 balance;

    constructor() {
        accHolder = msg.sender;
    }
    
    function withdraw() payable public  {
        require(balance > 0,"The balance must be greater than 0");
        require(msg.sender == accHolder, "You are not the account owner");
        payable(msg.sender).transfer(balance);
        balance = 0;

    }

    function deposit() public payable {
        require(msg.value > 0, "Deposit amount must be greater than 0");
        require(msg.sender == accHolder, "You are not the account owner");
        balance += msg.value;
    }

    function showBalance() public view returns(uint256) {
        require(msg.sender == accHolder, "You are not the account owner");
        return balance;
    }
}