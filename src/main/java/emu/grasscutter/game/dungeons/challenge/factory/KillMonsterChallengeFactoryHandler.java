package emu.grasscutter.game.dungeons.challenge.factory;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.dungeons.challenge.enums.ChallengeType;
import emu.grasscutter.game.dungeons.challenge.trigger.InTimeTrigger;
import emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.data.SceneGroup;

import java.util.List;

public class KillMonsterChallengeFactoryHandler implements ChallengeFactoryHandler{
    @Override
    public boolean isThisType(ChallengeType challengeType) {
        // ActiveChallenge with 180,180,45,133108061,1,0
        return challengeType == ChallengeType.CHALLENGE_KILL_COUNT_IN_TIME;
    }

    @Override
    public WorldChallenge build(int challengeIndex, int challengeId, int timeLimit, int groupId, int targetCount, int param6, Scene scene, SceneGroup group) {
        var realGroup = scene.getScriptManager().getGroupById(groupId);
        return new WorldChallenge(
                scene, realGroup,
                challengeId, // Id
                challengeIndex, // Index
                List.of(targetCount, timeLimit),
                timeLimit, // Limit
                targetCount,  // Goal
                List.of(new KillMonsterTrigger(), new InTimeTrigger())
                );
    }
}
