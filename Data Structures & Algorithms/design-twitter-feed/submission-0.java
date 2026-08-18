class Twitter {
    int timeStamp=0;
    private class User {
        int id;
        Set<Integer> following;
        Tweet tweetHead;
        public User(int id) {
            this.id=id;
            following=new HashSet<>();
            follow(id);
            tweetHead=null;
        }
        public void follow(int id) {
            following.add(id);
        }
        public void unfollow(int id) {
            if (id!=this.id) following.remove(id);
        }
        public void post(int id) {
            Tweet newTweet=new Tweet(id);
            newTweet.next=tweetHead;
            tweetHead=newTweet;
        }
    }
    
    private class Tweet {
        int id;
        int time;
        Tweet next;
        public Tweet(int id) {
            this.id=id;
            time=timeStamp++;
            next=null;
        }
    }

    private Map<Integer,User> users;
    
    public Twitter() {
        users=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) users.put(userId,new User(userId));
        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) users.put(userId,new User(userId));
        Set<Integer> following=users.get(userId).following;
        List<Integer> feed=new ArrayList<>();
        PriorityQueue<Tweet> tweets=new PriorityQueue<>(following.size(),(a,b)->b.time-a.time);
        for (int user:following) {
            Tweet tweet=users.get(user).tweetHead;
            if (tweet!=null) tweets.add(tweet);
        }
        int c=0;
        while (!tweets.isEmpty() && c<10) {
            Tweet tweet=tweets.poll();
            feed.add(tweet.id);
            c++;
            if (tweet.next!=null) tweets.offer(tweet.next);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) users.put(followerId,new User(followerId));
        if (!users.containsKey(followeeId)) users.put(followeeId,new User(followeeId));
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) users.put(followerId,new User(followerId));
        if (!users.containsKey(followeeId)) users.put(followeeId,new User(followeeId));
        users.get(followerId).unfollow(followeeId);
    }
}
