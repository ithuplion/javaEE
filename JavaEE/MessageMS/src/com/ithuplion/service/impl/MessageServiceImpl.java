package com.ithuplion.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ithuplion.MessageDao.MessageDao;
import com.ithuplion.MessageDaoImpl.MessageDaoImpl;
import com.ithuplion.domain.Message;
import com.ithuplion.service.MessageServie;

public class MessageServiceImpl implements MessageServie{
	Scanner input=new Scanner(System.in);
	private MessageDao md=new MessageDaoImpl();
	@Override
	public void menuRun() {
		System.out.println("************************************************");
		System.out.println("===========��ӭʹ������ϵͳv1.0==============");
		System.out.println("----------------------���˵�-------------------------");
		System.out.println("\t1.��ʾ������Ϣ");
		System.out.println("\t2.����������Ϣ");
		System.out.println("\t3.��ѯ������Ϣ");
		System.out.println("\t4.�˳�ϵͳ");
		System.out.println("************************************************");
		System.out.print("��ѡ��˵��");
		int op = input.nextInt();
		switch(op){
		case 1:
			this.displayAll();
			break;
		case 2:
			this.addOne();
			break;
		case 3:
			this.findMessageById();
			break;
		case 4:
			System.out.println("�˳�ϵͳ");
			System.exit(0);
			break;//�˳������
		}
	}
	@Override
	public void displayAll() {
		md.displayMessage();
	}

	@Override
	public void addOne() {
		System.out.print("���������Ա�ţ�");
		int id=input.nextInt();
		System.out.print("�����������ˣ�");
		String username=input.next();
		System.out.print("���������Ա��⣺");
		String title=input.next();
		System.out.print("�������������ݣ�\n");
		String content = input.next();
		Message message = new Message(id,username,title,content,new Date());
		md.addMessage(message);//����������Ϣ
	}
	@Override
	public void findMessageById() {
		System.out.print("���������Ա�ţ�");
		int id=input.nextInt();
		Message message = md.findById(id);
		System.out.println("�����ˣ�"+message.getUserName()+"\t���⣺"+message.getTitle()+"\t�������ݣ�"+message.getContents()+"\t�������ڣ�"+message.getCreateTime());
	}

}
