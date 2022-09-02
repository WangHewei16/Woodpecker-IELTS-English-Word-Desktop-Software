package GUI;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

import Function.TestWordRecommend;
import Function.Translate;
import com.iflytek.cloud.speech.Setting;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechUtility;
import util.Version;

/**
 * MscDemo It's a Sample using MSC SDK, include tts, isr. you can just press
 * button to use it.
 * 
 * @author cyhu 2012-06-14
 */
@SuppressWarnings("serial")
public class SpeakTestFrame extends JFrame {

	public JPanel mContentPanel;
	public int number;
	JLabel tipLabel;


	/**
	 * 界面初始化.
	 * 
	 */
	public SpeakTestFrame() throws IOException, ParseException {
		// 初始化
		StringBuffer param = new StringBuffer();
		SpeechUtility.createUtility(SpeechConstant.APPID + "=402cbb47");
		param.append( "appid=" + Version.getAppid() );
//		param.append( ","+SpeechConstant.LIB_NAME_32+"=myMscName" );
		//SpeechUtility.createUtility( param.toString() );
		Setting.setShowLog(false);
		this.setLayout(null);
		// 设置界面大小，背景图片
		/*ImageIcon background = new ImageIcon("res/index_bg.png");
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));*/

		int frameWidth = 618;
		int frameHeight = 677;

		setSize(frameWidth, frameHeight);
		setResizable(false);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




		tipLabel = new JLabel("Please speak out the word loudly!");
		tipLabel.setBounds(80, 150, 500, 180);
		tipLabel.setFont(new Font("微软雅黑" , Font.BOLD, 25));
		mContentPanel = new JPanel(new BorderLayout());
		mContentPanel.setOpaque(true);
		IatSpeechView iatSpeechView = new IatSpeechView();
		iatSpeechView.add(tipLabel);
		mContentPanel.add(iatSpeechView);
		mContentPanel.setBackground(Color.CYAN);
		//mContentPanel.add(jLabel);
		mContentPanel.setBounds(20, 80, 600, 600);

		setLocationRelativeTo(null);
		setContentPane(mContentPanel);
		iatSpeechView.speakTestFrame = this;

		setVisible(true);
	}
}