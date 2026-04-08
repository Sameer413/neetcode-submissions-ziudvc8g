class TimeMap {
    Map<String, ArrayList<TimeStampValue>> entriesByKey;

    public TimeMap() {
        entriesByKey = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!entriesByKey.containsKey(key)){
            entriesByKey.put(key, new ArrayList<>());
        }

        ArrayList<TimeStampValue> timeStampValue = entriesByKey.get(key);
        timeStampValue.add(new TimeStampValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!entriesByKey.containsKey(key)) return "";

        ArrayList<TimeStampValue> values = entriesByKey.get(key);
        Optional<TimeStampValue> timeStamp = bsTime(values, timestamp);

        if(timeStamp.isEmpty()){
            return "";
        }

        return timeStamp.get().value;
    }

    private Optional<TimeStampValue> bsTime(
        ArrayList<TimeStampValue> arr, int target
    ){
        int left = 0, right = arr.size() - 1;
        int matchIdx = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            TimeStampValue curr = arr.get(mid);

            if(curr.timestamp <= target){
                matchIdx = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        if(matchIdx == -1){
            return Optional.empty();
        }

        return Optional.of(arr.get(matchIdx));
    }
}

class TimeStampValue{
    public int timestamp;
    public String value;

    public TimeStampValue(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}