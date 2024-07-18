package Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class DesignTwitter {
	static int timeStamp = 0;
	Map<Integer, User> map;

	class Tweet {
		int id;
		int time;
		Tweet next;

		Tweet(int id) {
			this.id = id;
			time = timeStamp++;
			next = null;
		}
	}

	class User {
		int id;
		Set<Integer> followed;
		Tweet tweetHead;

		User(int id) {
			this.id = id;
			followed = new HashSet<>();
			follow(id);
			tweetHead = null;
		}

		void follow(int id) {
			followed.add(id);
		}

		void unfollow(int id) {
			followed.remove(id);
		}

		void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweetHead;
			tweetHead = t;
		}
	}

	DesignTwitter() {
		map = new HashMap<>();
	}

	void postTweet(int userId, int tweetId) {
		if (!map.containsKey(userId)) {
			User user = new User(userId);
			map.put(userId, user);
		}
		map.get(userId).post(tweetId);
	}

	List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new LinkedList<>();
		if (!map.containsKey(userId)) {
			return res;
		}
		Tweet tweet;
		Set<Integer> users = map.get(userId).followed;
		PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));
		for (int user : users) {
			tweet = map.get(user).tweetHead;
			if (tweet != null) {
				pq.add(tweet);
			}
		}
		while (!pq.isEmpty() && res.size() < 10) {
			tweet = pq.poll();
			res.add(tweet.id);
			if (tweet.next != null) {
				pq.add(tweet.next);
			}
		}
		return res;
	}

	void follow(int followerId, int followeeId) {
		if (!map.containsKey(followerId)) {
			map.put(followerId, new User(followerId));
		}
		if (!map.containsKey(followeeId)) {
			map.put(followeeId, new User(followeeId));
		}
		map.get(followerId).follow(followeeId);
	}

	void unfollow(int followerId, int followeeId) {
		if (!map.containsKey(followerId) || followerId == followeeId) {
			return;
		}
		map.get(followerId).unfollow(followeeId);
	}

	@Override
	public String toString() {
		return "";
	}
	
	public static void main(String[] args) {
		DesignTwitter twitter = new DesignTwitter();
		twitter.postTweet(1, 5);
		twitter.getNewsFeed(1);
		twitter.follow(1, 2);
		twitter.postTweet(2, 6);
		twitter.getNewsFeed(1);
		twitter.unfollow(1, 2);
		twitter.getNewsFeed(1);
	}
}