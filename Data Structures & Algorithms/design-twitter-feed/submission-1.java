class Twitter {
    int tweetNum = 0;
    HashMap<Integer,List<Integer>> followings = new HashMap<>();
    HashMap<Integer,PriorityQueue<int[]>> ownTweets = new HashMap<>();
    HashMap<Integer,PriorityQueue<int[]>> tweets = new HashMap<>();

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] arr = {tweetNum,userId,tweetId};
        if(!tweets.containsKey(userId)){
            PriorityQueue<int[]> q = new PriorityQueue<>(
                new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        return b[0] - a[0];
                    }
                }
            );
            q.add(arr);
            tweets.put(userId,q);
        }
        else{
            tweets.get(userId).add(arr);
        }
        if(!ownTweets.containsKey(userId)){
            PriorityQueue<int[]> q = new PriorityQueue<>(
                new Comparator<int[]>(){
                    public int compare(int[] a,int[] b){
                        return b[0] - a[0];
                    }
                }
            );
            q.add(arr);
            ownTweets.put(userId,q);
        }
        else{
            ownTweets.get(userId).add(arr);
        }
        for(Integer id : followings.keySet()){
            if(followings.get(id).contains(userId)){
                if(!tweets.containsKey(id)){
                    PriorityQueue<int[]> q = new PriorityQueue<>(
                        new Comparator<int[]>(){
                            public int compare(int[] a,int[] b){
                                return b[0] - a[0];
                            }
                        }
                    );
                    q.add(arr);
                    tweets.put(id,q);
                }
                else{
                    tweets.get(id).add(arr);
                }
            }
        }
        tweetNum++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!tweets.containsKey(userId)){
            return res;
        }
        else{
            ArrayList<int[]> list = new ArrayList<>();
            PriorityQueue<int[]> queue = tweets.get(userId);

            if(queue.size() < 10){
                while(!queue.isEmpty()){
                    res.add(queue.peek()[2]);
                    list.add(queue.poll());
                }
            }
            else{
                for(int i=0;i<10;i++){
                    res.add(queue.peek()[2]);
                    list.add(queue.poll());
                }
            }
            for(int[] array : list){
                queue.add(array);
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        boolean alreadyFollowing = (followings.containsKey(followerId) && followings.get(followerId).contains(followeeId)) ? true : false;
        if(alreadyFollowing == false && followerId != followeeId){
            if(followings.containsKey(followerId)){
                followings.get(followerId).add(followeeId);
            }
            else{
                followings.put(followerId,new ArrayList<>(List.of(followeeId)));
            }
            if(ownTweets.containsKey(followeeId)){
                if(tweets.containsKey(followerId)){
                    for(int[] arr : ownTweets.get(followeeId)){
                        tweets.get(followerId).add(arr);
                    }
                }
                else{
                    PriorityQueue<int[]> q = new PriorityQueue<>(
                        new Comparator<int[]>(){
                            public int compare(int[] a,int[] b){
                                return b[0] - a[0];
                            }
                        }
                    );
                    for(int[] arr : ownTweets.get(followeeId)){
                        q.add(arr);
                    }
                    tweets.put(followerId,q);
                }
            }
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followings.get(followerId).remove(Integer.valueOf(followeeId));
            if(ownTweets.containsKey(followeeId)){
                Iterator<int[]> it = tweets.get(followerId).iterator();
                while(it.hasNext()){
                    int[] cur = it.next();
                    if(cur[1] == followeeId){
                        it.remove();
                    }
                }
            }
        }
        
    }
}
