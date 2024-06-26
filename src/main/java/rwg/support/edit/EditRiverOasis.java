package rwg.support.edit;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;

import rwg.deco.DecoCacti;
import rwg.deco.DecoFlowers;
import rwg.deco.DecoGrass;
import rwg.deco.trees.DecoSavannah;
import rwg.util.CellNoise;
import rwg.util.NoiseGenerator;

public class EditRiverOasis extends EditBase {

    public EditRiverOasis() {}

    @Override
    public void decorate(World world, Random rand, int chunkX, int chunkY, NoiseGenerator perlin, CellNoise cell,
            float strength, float river) {
        if (river > 0.7f) {
            if (river > 0.86f) {
                for (int b33 = 0; b33 < 10f * strength; b33++) {
                    int j6 = chunkX + rand.nextInt(16) + 8;
                    int k10 = chunkY + rand.nextInt(16) + 8;
                    int z52 = world.getHeightValue(j6, k10);

                    if (z52 < 100f || (z52 < 120f && rand.nextInt(10) == 0)) {
                        WorldGenerator worldgenerator = rand.nextInt(4) != 0 ? new WorldGenShrub(0, 0)
                                : new DecoSavannah(1);
                        worldgenerator.setScale(1.0D, 1.0D, 1.0D);
                        worldgenerator.generate(world, rand, j6, z52, k10);
                    }
                }
            }

            for (int k18 = 0; k18 < 12f * strength; k18++) {
                int k21 = chunkX + rand.nextInt(16) + 8;
                int j23 = rand.nextInt(160);
                int k24 = chunkY + rand.nextInt(16) + 8;
                if (j23 < 120f) {
                    (new DecoCacti(false)).generate(world, rand, k21, j23, k24);
                }
            }

            for (int f25 = 0; f25 < 2f * strength; f25++) {
                int i18 = chunkX + rand.nextInt(16) + 8;
                int i23 = chunkY + rand.nextInt(16) + 8;
                (new WorldGenReed()).generate(world, rand, i18, 60 + rand.nextInt(8), i23);
            }

            if (rand.nextInt(28) == 0) {
                int j16 = chunkX + rand.nextInt(16) + 8;
                int j18 = rand.nextInt(128);
                int j21 = chunkY + rand.nextInt(16) + 8;
                (new WorldGenPumpkin()).generate(world, rand, j16, j18, j21);
            }

            for (int f23 = 0; f23 < 3; f23++) {
                int j15 = chunkX + rand.nextInt(16) + 8;
                int j17 = rand.nextInt(128);
                int j20 = chunkY + rand.nextInt(16) + 8;
                (new DecoFlowers(new int[] { 9, 9, 9, 9, 3, 3, 3, 3, 3, 2, 2, 2, 11, 11, 11 }))
                        .generate(world, rand, j15, j17, j20);
            }

            for (int l14 = 0; l14 < 15; l14++) {
                int l19 = chunkX + rand.nextInt(16) + 8;
                int k22 = rand.nextInt(128);
                int j24 = chunkY + rand.nextInt(16) + 8;

                if (rand.nextInt(6) == 0) {
                    (new DecoGrass(Blocks.double_plant, 2)).generate(world, rand, l19, k22, j24);
                } else {
                    (new DecoGrass(Blocks.tallgrass, 1)).generate(world, rand, l19, k22, j24);
                }
            }
        }
    }
}
