package com.example.songcloudclient.response;

import com.example.songcloudclient.model.Song;

import java.util.Map;

public record AllSongsResponse(Map<Integer, Song> songs) {
}
