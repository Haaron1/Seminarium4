/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.pos.controller;

/**
 *
 * The exception for server problems.
 */
public class ServerErrorException extends Exception{
    public ServerErrorException(String msg){
        super(msg);
    }
}
