package com.example.songcloudclient.response;

import com.example.songcloudclient.model.Song;

import java.util.Map;

public record SingleSongResponse(Map<String, String> song) {
}
