package com.example.songcloudclient.response;

import com.example.songcloudclient.model.Song;

public record UpdateSongByPatchResponse(Song updatedSong) {
}
