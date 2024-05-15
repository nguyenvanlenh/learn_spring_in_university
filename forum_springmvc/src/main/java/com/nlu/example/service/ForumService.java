package com.nlu.example.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nlu.example.model.Category;
import com.nlu.example.model.Message;
import com.nlu.example.model.Topic;
import com.nlu.example.model.User;

@Service
public class ForumService {
	private static final ForumService instance = new ForumService();
	private Map<String, User> users;
	private Map<Integer, Topic> topics;

	public ForumService() {
		init();
	}

	private void init() {
		users = new HashMap<String, User>();
		topics = new HashMap<Integer, Topic>();
		Category cat1 = new Category("Học hành");

		users.put("chuotcon", new User("chuotcon", "chuotcon", "lehoang@yahoo.com",
				new GregorianCalendar(2008, Calendar.FEBRUARY, 22).getTime()));
		users.put("leb",
				new User("leb", "leb", "ntlan@yahoo.com", new GregorianCalendar(2007, Calendar.APRIL, 15).getTime()));
		users.put("doctorQ", new User("doctorQ", "doctorQ", "mjohn@yahoo.com",
				new GregorianCalendar(2008, Calendar.FEBRUARY, 22).getTime()));
		users.put("itss", new User("itss", "itss", "vovanthang@yahoo.com",
				new GregorianCalendar(2007, Calendar.AUGUST, 30).getTime()));
		users.put("dt03", new User("dt03", "dt03", "dotuan@hotmail.com",
				new GregorianCalendar(2007, Calendar.JANUARY, 7).getTime()));
		users.put("GSKH",
				new User("GSKH", "GSKH", "giasu@yahoo.com", new GregorianCalendar(2007, Calendar.JULY, 14).getTime()));

		Topic topic1 = new Topic(1, "Chuyện học phí!!!",
				"Từ lớp mẫu giáo đến lớp 12-trường công-Tại sao lại phải đóng học phí?!", users.get("doctorQ"),
				cat1);
		topic1.addMessage(new Message("Re: Chuyện học phí!!!",
				"Thưa anh (chị) em muôn hỏi là sinh viên dân tộc thiểu số có được miễn giảm "
						+ "học phí hay không? Và những yêu cầu gì đối với sinh viên "
						+ "dân tôc thiểu số để được miễn giảm học phí? Em cảm ơn anh (chị)\nNgoc Linh",
				users.get("chuotcon")));

		Topic topic2 = new Topic(2, "Thủ tướng: Trường ĐH tự quyết mức học phí",
				"Học phí mầm non và phổ thông ở trường công lập là sự đóng góp một phần nhỏ "
						+ "của người dân, phù hợp với khả năng chi trả của các gia đình, để chia sẻ chi phí "
						+ "đào tạo với Nhà nước. Đối với đào tạo nghề nghiệp từ trình độ sơ cấp đến đại học "
						+ "ở các trường công lập, học phí là sự chia sẻ quan trọng của người học trong chi "
						+ "phí đào tạo",
				users.get("leb"), cat1);
		topic2.addMessage(new Message("Re: Thủ tướng: Trường ĐH tự quyết mức học phí", "Cái nào cũng có mặt lợi và hại của nó. Nếu trường tự chủ thì học phí sẽ tăng và chất lượng giảng viên cũng tăng do chi phí học cao.",
				users.get("GSKH")));
		Topic topic3 = new Topic(3, "Học phí trái buổi",
				"Cháu học trường THPT Trần khai nguyên Q5....Lớp 12\n"
						+ "Tiền học chính quy 110.000đ/tháng (1 tuần=30tiết) trong khi đó tiền học trái buổi "
						+ "130.000đ (1tuần=7-9 tiết) vậy có bất hợp lý quá không.Tiền học phí gần gấp đôi "
						+ "năm ngóai (70.000đ)",
				users.get("itss"), cat1);
		topic3.addMessage(new Message("Re: Học phí trái buổi", "Điều này quá bất hợp lý.",
				users.get("GSKH")));
		Topic topic4 = new Topic(4, "Một số mốc quan trọng trong đề án \"Tăng học phí\"",
				"# Ngày 4/9, trước khai giảng một ngày, Thủ tướng Chính phủ ban hành chỉ thị cho sinh viên vay vốn học tập với tinh thần "
						+ "\"không để sinh viên bỏ học vì không có tiền đóng học phí\". ",
				users.get("dt03"), cat1);

		topic4.addMessage(new Message("Re: Một số mốc quan trọng trong đề án \"Tăng học phí\"", "Tạm hoãn lại rồi.",
				users.get("GSKH")));
		Topic topic5 = new Topic(5, "Xung quanh dự thảo của Đề án tăng học phí",
				"Ngoài phần hỗ trợ của Nhà nước theo khả năng ngân sách, học phí cần bảo đảm trang "
						+ "trải chi phí cần thiết cho giảng dạy, học tập và có tích luỹ để đầu tư phát triển nhà "
						+ "trường, đủ bù đắp chi phí thường xuyên.\n"
						+ "Đề án được xây dựng theo tinh thần Nghị quyết số 05/2005/NQ-CP của Chính phủ. ",
				users.get("leb"), cat1);
		topic5.addMessage(new Message("Re: Xung quanh dự thảo của Đề án tăng học phí",
				"Nói vậy những quốc gia như Đức và Malaysia họ có được GD miễn phí là do Đức Chúa Trời "
						+ "và Đức Ala phò hộ, còn ta theo XHCN vô thần nên dân phải è cổ ra mà đóng học phí. "
						+ "XHCN mà phúc lợi xã hội và bình đẳng giai cấp còn thua các quốc gia \"phong kiến lạc hậu\""
						+ " và \"tư bản giãy chết\" thì XHCN làm cái gì đây? Lúc nói tới tính ưu việt của XHCN sao "
						+ "không thấy ai nhắc tới cái này.",
				users.get("GSKH")));
		topic5.addMessage(new Message("Re: Xung quanh dự thảo của Đề án tăng học phí",
				"Thực tế như nước Đức và các nước Bắc Âu họ đi lên CNXH trước chúng ta (mặc dù họ không "
						+ "hô hào nhưng điều họ làm thể hiện nó), XHCN là cái đích để chúng ta phấn đấu và vươn tới. "
						+ "Khi mà xã hội giàu có, dân trí cao thì phúc lợi xã hội sẽ tốt. Chúng ta chưa giàu như họ "
						+ "nên chưa thể miễn học phí mà có chất lượng đào tạo tốt được.",
				users.get("itss")));
		topic5.addMessage(new Message("Re: Xung quanh dự thảo của Đề án tăng học phí", "Sẽ làm nước lạc hậu hơn",
				users.get("GSKH")));

		topics.put(1, topic1);
		topics.put(2, topic2);
		topics.put(3, topic3);
		topics.put(4, topic4);
		topics.put(5, topic5);
	}

	public Collection<Topic> getTopics() {
		return topics.values();
	}

	public User checkUser(String name, String password) {
		User user = users.get(name);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public Topic findTopic(Integer id) {
		return topics.get(id);
	}

	public static ForumService getInstance() {
		return instance;
	}
}
